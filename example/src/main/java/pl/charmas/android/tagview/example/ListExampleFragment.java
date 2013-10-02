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

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;
import java.util.List;

import pl.charmas.android.tagview.R;
import pl.charmas.android.tagview.TagView;

public class ListExampleFragment extends ListFragment{

    private LinkedList<TagView.Tag> tagList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tagList = ((MainActivity) getActivity()).createTagList();
        setListAdapter(new ExampleAdapter());
    }

    private class ExampleAdapter extends BaseAdapter {

        private LayoutInflater inflater = LayoutInflater.from(getActivity());

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public List<TagView.Tag> getItem(int position) {
            return tagList;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.tags_list_item, parent, false);
                ((TagView)convertView).setTags(getItem(position), " ");
            }
            return convertView;
        }
    }
}
