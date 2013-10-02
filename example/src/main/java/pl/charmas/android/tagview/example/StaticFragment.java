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

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.charmas.android.tagview.R;
import pl.charmas.android.tagview.TagView;

public class StaticFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.static_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TagView tv = (TagView) getView().findViewById(R.id.tags_view);
        TagView.Tag[] tags = {
                new TagView.Tag("Sample tag", Color.parseColor("#0099CC")),
                new TagView.Tag("Another one", Color.parseColor("#9933CC"))
        };
        tv.setTags(tags, " ");
    }
}
