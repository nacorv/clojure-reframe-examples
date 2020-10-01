# Clojure Web Framework Example

This page was put together using the [Luminus framework](https://luminusweb.com/).

It also takes advantage of the [re-frame framework](https://github.com/day8/re-frame) to create React components from ClojureScript.

The CSS styling is handled by [tachyons.css](https://tachyons.io/) which I feel goes great with the above!


Here is an example of defining the HTML element for a button using Hiccup syntax and styling it with Tachyons:

```
(defn nav-link [uri title page]
  [:a.link.pv2.dib.white.bg-black.outline.w-25.pa3.mr2
   {:href   uri
    :class (when (= page @(rf/subscribe [:common/page])) :is-active)}
   title])
```

 Taking notice of how the `[:a]` is defined, it is interesting to see that the button's styling defined by the composition of CSS classes:
 
 ` [:a.link.pv2.dib.white.bg-black.outline.w-25.pa3.mr2`  