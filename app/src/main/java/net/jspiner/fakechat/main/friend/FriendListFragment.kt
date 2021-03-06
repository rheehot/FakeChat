package net.jspiner.fakechat.main.friend

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.fakechat.R
import net.jspiner.fakechat.databinding.FragmentFriendListBinding
import net.jspiner.fakechat.repository.database.FakeChatDatabase

class FriendListFragment : BaseFragment<FragmentFriendListBinding, FriendListViewModel>() {

    private val adapter by lazy { FriendListAdapter() }

    override fun getLayoutId() = R.layout.fragment_friend_list

    override fun createViewModel() = FriendListViewModel(
            FakeChatDatabase.getInstance(context).myProfileDao(),
            FakeChatDatabase.getInstance(context).profileDao()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                binding.toolbar.elevation = if(recyclerView.canScrollVertically(-1)) {
                    50f
                } else 0f
            }
        })

        observeViewModel()

        viewModel.loadMyProfile()
        viewModel.loadFriendList()
    }

    private fun observeViewModel() {
        viewModel.myProfile.observe(viewLifecycleOwner, Observer { profile ->
            adapter.updateMyProfile(profile)
        })
        viewModel.friendProfileList.observe(viewLifecycleOwner, Observer { list ->
            adapter.updateFriendProfileList(list)
        })
    }
}