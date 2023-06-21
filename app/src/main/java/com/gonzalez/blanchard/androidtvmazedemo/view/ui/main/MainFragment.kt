package com.gonzalez.blanchard.androidtvmazedemo.view.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener
import androidx.leanback.widget.PresenterSelector
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.gonzalez.blanchard.androidtvmazedemo.R
import com.gonzalez.blanchard.androidtvmazedemo.data.repository.TvShowRepository
import com.gonzalez.blanchard.androidtvmazedemo.domain.models.TvShowItem
import com.gonzalez.blanchard.androidtvmazedemo.view.viewmodel.MainViewModel
import com.gonzalez.blanchard.androidtvmazedemo.view.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch

class MainFragment: BrowseSupportFragment() {

    private val backgroundState = BackgroundState(this)

    private val mainVM by viewModels<MainViewModel> {
        MainViewModelFactory(TvShowRepository())
    }

    private val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = getString(R.string.browse)

        adapter = rowsAdapter

        onItemViewClickedListener =
            OnItemViewClickedListener { vh, movie, _, _ ->
             /*   val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    requireActivity(),
                    (vh.view as ImageCardView).mainImageView,
                    DetailActivity.SHARED_ELEMENT_NAME
                ).toBundle()

                val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                    putExtra(DetailActivity.MOVIE_EXTRA, movie as Movie)
                }
                startActivity(intent, bundle)  */
            }

        onItemViewSelectedListener = OnItemViewSelectedListener { _, tvshow, _, _ ->
            (tvshow as? TvShowItem)?.let { backgroundState.loadUrl(tvshow.image.original) }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                mainVM.state.collect {
                    if (it.isLoading) progressBarManager.show() else progressBarManager.hide()
                    updateUi(it.categories)
                }
            }
        }

        mainVM.onUiReady()
    }

    private fun updateUi(categories: Map<String, List<TvShowItem>>) {
        rowsAdapter.clear()
        val cardPresenter = CardPresenter()
        categories.forEach { (category, movies) ->
            val listRowAdapter = ArrayObjectAdapter(cardPresenter).apply {
                addAll(0, movies)
            }

            val header = HeaderItem(category)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }
    }

    override fun setHeaderPresenterSelector(headerPresenterSelector: PresenterSelector?) {
        super.setHeaderPresenterSelector(headerPresenterSelector)
    }

}

