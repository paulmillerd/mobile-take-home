package com.paulmillerd.rickandmorty.di.module;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.paulmillerd.rickandmorty.repository.CharacterDetailRepository;
import com.paulmillerd.rickandmorty.repository.EpisodeRepository;
import com.paulmillerd.rickandmorty.repository.ICharacterDetailRepository;
import com.paulmillerd.rickandmorty.repository.IEpisodeRepository;
import com.paulmillerd.rickandmorty.rickAndMortyApi.IRickAndMortyService;

import javax.inject.Singleton;

import androidx.collection.LruCache;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    IEpisodeRepository providesEpisodeRepository(IRickAndMortyService rickAndMortyService) {
        return new EpisodeRepository(rickAndMortyService);
    }

    @Provides
    @Singleton
    ICharacterDetailRepository providesCharacterDetailRepository(IRickAndMortyService rickAndMortyService) {
        return new CharacterDetailRepository(rickAndMortyService);
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader() {
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        return new ImageLoader(requestQueue, new ImageLoader.ImageCache() {

            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);

            @Override
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }

        });
    }

}
