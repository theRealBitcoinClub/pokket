package xyz.pokkst.pokket.ui.main.fragment.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_intro_bg.view.*
import kotlinx.android.synthetic.main.fragment_new_wallet.view.*
import kotlinx.android.synthetic.main.intro_fragment_warning.view.*
import xyz.pokkst.pokket.R
import xyz.pokkst.pokket.util.StatusBarHelper

/**
 * A placeholder fragment containing a simple view.
 */
class NewWalletFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_new_wallet, container, false)
        root.intro_new_wallet_generate.setOnClickListener {
            if (root.seed_warning_screen.visibility != View.VISIBLE) {
                StatusBarHelper.setStatusBarColor(activity, R.color.purple_dark)
                root.seed_warning_screen.visibility = View.VISIBLE
            }
        }

        root.intro_warning_show_button.setOnClickListener {
            val isMultisigChecked = root.multsig_checkbox.isChecked
            val action =
                NewWalletFragmentDirections.navToGeneratedSeed(
                    isMultisigChecked
                )
            findNavController().navigate(action)
            StatusBarHelper.setStatusBarColor(activity, R.color.extra_light_grey)
        }

        root.intro_left_button.setOnClickListener {
            findNavController().popBackStack()
        }

        return root
    }
}