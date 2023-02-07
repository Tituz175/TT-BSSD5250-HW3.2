package com.example.tt_bssd5250_hw32

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

class NoteEditorDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val editName = EditText(requireContext()).apply {
            setHint(R.string.name_place_holder)
        }
        val editDate = EditText(requireContext()).apply {
            setHint(R.string.date_place_holder)
        }
        val editDesc = EditText(requireContext()).apply {
            setHint(R.string.desc_place_holder)
        }

        val linearLayout = LinearLayoutCompat(requireContext()).apply {
            orientation = LinearLayoutCompat.VERTICAL
            addView(editName)
            addView(editDate)
            addView(editDesc)
        }

        val ad = AlertDialog.Builder(requireContext()).apply {
            setTitle("Note Editor")
            setTitle("Edit Content")
            setView(linearLayout)
            setPositiveButton("Save") { _, _ ->
                val name = editName.text.toString()
                val date = editDate.text.toString()
                val desc = editDesc.text.toString()
                setFragmentResult(
                    "noteDataChange",
                    bundleOf("nameKey" to name, "dateKey" to date, "descKey" to desc)
                )
            }
            setNegativeButton("Cancel") { _, _ -> }
        }
        return ad.create()
    }

    companion object {
        const val TAG = "NoteEditorDialog"

        @JvmStatic
        fun newInstance() =
            NoteEditorDialog().apply {

            }
    }
}