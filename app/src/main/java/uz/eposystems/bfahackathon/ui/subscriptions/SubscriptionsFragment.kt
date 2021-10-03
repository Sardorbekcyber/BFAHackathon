package uz.eposystems.bfahackathon.ui.subscriptions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.eposystems.bfahackathon.R
import uz.eposystems.bfahackathon.databinding.SubscriptionsFragmentBinding

@AndroidEntryPoint
class SubscriptionsFragment : Fragment() {

    private val viewModel by viewModels<SubscriptionsViewModel>()
    private var _binding : SubscriptionsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SubscriptionsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}