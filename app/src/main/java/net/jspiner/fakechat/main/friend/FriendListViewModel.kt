package net.jspiner.fakechat.main.friend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.jspiner.ask.ui.base.BaseViewModel
import net.jspiner.ask.util.bindLifecycle
import net.jspiner.fakechat.main.friend.item.FriendProfileItem
import net.jspiner.fakechat.main.friend.item.MyProfileItem
import net.jspiner.fakechat.repository.dao.MyProfileDao
import net.jspiner.fakechat.repository.dao.ProfileDao

class FriendListViewModel(
    private val myProfileDao: MyProfileDao,
    private val profileDao: ProfileDao
) : BaseViewModel() {

    private val _myProfile = MutableLiveData<MyProfileItem>(MyProfileItem.EMPTY)
    val myProfile: LiveData<MyProfileItem> = _myProfile

    private val _friendProfileList = MutableLiveData<List<FriendProfileItem>>(emptyList())
    val friendProfileList: LiveData<List<FriendProfileItem>> = _friendProfileList

    fun loadMyProfile() {
        myProfileDao.getMyProfile()
            .map {
                MyProfileItem(
                    it.profile.id,
                    it.profile.profileImage,
                    it.profile.name,
                    it.profile.statusMessage
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profile ->
                _myProfile.value = profile
            }.bindLifecycle(lifecycle)
    }

    fun loadFriendList() {
        profileDao.loadFriendProfiles()
            .map { list ->
                list.map {
                    FriendProfileItem(
                        it.id,
                        it.profileImage,
                        it.name,
                        it.statusMessage
                    )
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profiles ->
                _friendProfileList.value = profiles
            }.bindLifecycle(lifecycle)
    }
}