/**
 * Copyright 2013 Michał Charmas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.charmas.android.tagview.example;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.LinkedList;

import pl.charmas.android.tagview.R;
import pl.charmas.android.tagview.TagView;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.fragment_pager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
    }

    private class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return i == 0 ? new StaticFragment() : new ListExampleFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    public LinkedList<TagView.Tag> createTagList() {
        TypedArray typedArray = getResources().obtainTypedArray(R.array.colors);
        int[] colors = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            colors[i] = typedArray.getColor(i, 0);
        }
        typedArray.recycle();

        String[] tagContents = getResources().getStringArray(R.array.tags);
        LinkedList<TagView.Tag> tags = new LinkedList<TagView.Tag>();
        int i = 0;
        for (String content : tagContents) {
            tags.add(new TagView.Tag(content, colors[i++ % colors.length]));
        }
        return tags;
    }

}
