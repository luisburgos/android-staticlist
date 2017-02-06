Android Static List
==========================

Usage
=====

### 1.- Configuring your Project Dependencies

Add the reference to the Bintray repository in your project-level build.gradle file.

```groovy
allprojects {
  repositories {
    // ...
    maven { url 'https://dl.bintray.com/luisburgos/staticlist' }
  }
}
```

The, Add the library dependency to your module-level build.gradle file.

```groovy
dependencies {
  // ...
  compile 'com.luisburgos:staticlist:0.1.0'
}
```

### 2.- Configure your fragment

Extend your Fragment from `StaticListFragment` and override

```java
public class MyStaticListFragment extends StaticListFragment {

    @Override
    protected List<StaticListItem> setupStaticListItems() {
        List<StaticListItem> items = new ArrayList<>();

        items.add(new StaticListItem("Option 1", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));
        items.add(new StaticListItem("Option 2", StaticListItem.TYPES.BASIC));
        items.add(new StaticListItem("Option 3", StaticListItem.TYPES.BASIC_RIGHT_DETAIL));

        return items;
    }

    public static MyStaticListFragment newInstance() {
        Bundle arguments = new Bundle();
        MyStaticListFragment fragment = new MyStaticListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }
}
```

### 3.- Setup the Item Listener

Implement the interface `OnStaticListItemClickListener` provided by the `StaticListRecyclerViewAdapter` class

```java
public class MyStaticListFragment extends StaticListFragment implements StaticListRecyclerViewAdapter.OnStaticListItemClickListener {

    ...

    @Override
    public void onItemClick(StaticListItem item) {
        Toast.makeText(getContext(), "Click item " + String.valueOf(item.getTitle()), Toast.LENGTH_SHORT).show();
    }

    ...
}
```

### 4.- Make sure to set the Listener properly

Override the `onCreate` method in order to set the listener to the StaticListFragment

```java
public class MyStaticListFragment extends StaticListFragment implements StaticListRecyclerViewAdapter.OnStaticListItemClickListener {

    ...

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setOptionsListener(this);
    }

    ...
}
```

**NOTE:** You can see another ways of use [here](https://github.com/LuisBurgos/android-staticlist/tree/master/app/src/main/java/com/luisburgos/androidstaticlist)


Developed By
============

 * Luis Burgos - <luisarturo.burgos@gmail.com>

License
=======

    Copyright 2017 Luis Burgos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
