package net.jspiner.fakechat.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import net.jspiner.ask.ui.base.BaseActivity
import net.jspiner.fakechat.R
import net.jspiner.fakechat.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun createViewModel() = MainViewModel()

    override fun loadState(bundle: Bundle) {
        // no-op
    }

    override fun saveState(bundle: Bundle) {
        // no-op
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.pager.adapter = MainPagerAdapter(supportFragmentManager)
        binding.tab.setupWithViewPager(binding.pager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}