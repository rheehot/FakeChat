package net.jspiner.fakechat.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import net.jspiner.fakechat.main.chat.ChatListFragment

class MainPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return ChatListFragment() // TODO
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