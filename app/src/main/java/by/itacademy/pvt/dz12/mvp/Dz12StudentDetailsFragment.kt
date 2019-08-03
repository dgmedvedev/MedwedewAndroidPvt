package by.itacademy.pvt.dz12.mvp

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import by.itacademy.pvt.R
import by.itacademy.pvt.dz12.Student
import by.itacademy.pvt.utils.loadRoundImage

class Dz12StudentDetailsFragment : Fragment(), Dz12StudentDetailsView {

    private lateinit var presenter: Dz12StudentDetailsPresenter

    private var listener: Listener? = null

    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var photoStudentImageView: ImageView
    private lateinit var deleteButton: Button
    private lateinit var editButton: Button

    companion object {
        private const val ID_STUDENT = "ID_STUDENT"

        fun getInstance(id: String): Dz12StudentDetailsFragment {
            val fragment = Dz12StudentDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_STUDENT, id)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Listener)
            listener = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_details_student_dz8, container, false)

        val idStudent = arguments?.getString(ID_STUDENT, "-1")

        presenter = Dz12StudentDetailsPresenter(idStudent)
        presenter.setView(this)

        nameTextView = view.findViewById(R.id.name_details_student)
        ageTextView = view.findViewById(R.id.age_details_student)
        photoStudentImageView = view.findViewById(R.id.photo_details_student)
        deleteButton = view.findViewById(R.id.delete)
        editButton = view.findViewById(R.id.edit)

        presenter.getStudentById()

        return view
    }

    override fun backStack() {
        activity?.supportFragmentManager?.popBackStack()
    }

    override fun showStudent(student: Student) {
        nameTextView.text = student.name
        ageTextView.text = student.age.toString()
        loadRoundImage(student.imageUrl, photoStudentImageView)

        deleteButton.setOnClickListener {
            presenter.deleteButtonWasClicked()
            backStack()
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
                listener?.startDz12StudentListFragment()
        }

        editButton.setOnClickListener {
            listener?.onEditStudentClick(student.id)
        }
    }

    override fun onError() {
        Toast.makeText(
            context,
            resources.getText(R.string.id_not_found),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null

        presenter.onDestroy()
    }

    interface Listener {
        fun onEditStudentClick(id: String)
        fun startDz12StudentListFragment()
    }
}