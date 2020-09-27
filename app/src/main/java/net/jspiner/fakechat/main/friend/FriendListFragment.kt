package net.jspiner.fakechat.main.friend

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.fakechat.R
import net.jspiner.fakechat.databinding.FragmentFriendListBinding
import net.jspiner.fakechat.main.friend.item.DividerItem
import net.jspiner.fakechat.main.friend.item.FriendProfileItem
import net.jspiner.fakechat.main.friend.item.MyProfileItem
import kotlin.random.Random

class FriendListFragment : BaseFragment<FragmentFriendListBinding, FriendListViewModel>() {

    private val adapter by lazy { FriendListAdapter() }

    override fun getLayoutId() = R.layout.fragment_friend_list

    override fun createViewModel() = FriendListViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        // TODO
        adapter.addAll(
                listOf(
                        MyProfileItem("user1", "https://picsum.photos/200?seed=my", "존스미스", "내 프로필 입니다."),
                        DividerItem("친구 128명")
                ) + (0..100).map { id ->
                    FriendProfileItem("user$id", "https://picsum.photos/200?seed=$id", "랜덤프로필$id", "랜덤")
                }
        )

    }
}