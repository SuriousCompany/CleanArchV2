package company.surious.cleanarchv2.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import company.surious.cleanarchv2.R
import company.surious.cleanarchv2.ui.sample.SampleFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displaySampleFragment()
    }

    private fun displaySampleFragment() {
        val tag = SampleFragment::class.simpleName
        var sampleFragment =
            supportFragmentManager.findFragmentByTag(tag)
        if (sampleFragment == null) {
            sampleFragment = SampleFragment()
            supportFragmentManager.beginTransaction().add(R.id.main_root, sampleFragment, tag)
                .commit()
        }
    }
}
