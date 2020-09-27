package net.jspiner.fakechat.main.chat

import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.fakechat.R
import net.jspiner.fakechat.databinding.FragmentChatListBinding

class ChatListFragment : BaseFragment<FragmentChatListBinding, ChatListViewModel>() {
    override fun getLayoutId() = R.layout.fragment_chat_list

    override fun createViewModel() = ChatListViewModel()
}