package net.jspiner.fakechat.main

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import net.jspiner.fakechat.main.chat.ChatListFragment
import net.jspiner.fakechat.main.friend.FriendListFragment

class MainPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = when(position) {
        0 -> FriendListFragment()
        1 -> ChatListFragment()
        2 -> ChatListFragment() // TODO
        3 -> ChatListFragment() // TODO
        else -> throw UnsupportedOperationException("")
    }
    override fun getCount() = 4

    override fun getPageTitle(position: Int) = when (position) {
        0 -> "친구"
        1 -> "채팅"
        2 -> "검색"
        3 -> "설정"
        else -> throw UnsupportedOperationException("")
    }
}