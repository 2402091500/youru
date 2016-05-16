// Generated code from Butter Knife. Do not modify!
package com.example.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.example.ui.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361797, "field 'viewPager1'");
    target.viewPager1 = finder.castView(view, 2131361797, "field 'viewPager1'");
    view = finder.findRequiredView(source, 2131361799, "field 'tv1' and method 'onClick'");
    target.tv1 = finder.castView(view, 2131361799, "field 'tv1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361800, "field 'tv2' and method 'onClick'");
    target.tv2 = finder.castView(view, 2131361800, "field 'tv2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361801, "field 'tv3' and method 'onClick'");
    target.tv3 = finder.castView(view, 2131361801, "field 'tv3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361802, "field 'tv4' and method 'onClick'");
    target.tv4 = finder.castView(view, 2131361802, "field 'tv4'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361798, "field 'caidan'");
    target.caidan = finder.castView(view, 2131361798, "field 'caidan'");
  }

  @Override public void unbind(T target) {
    target.viewPager1 = null;
    target.tv1 = null;
    target.tv2 = null;
    target.tv3 = null;
    target.tv4 = null;
    target.caidan = null;
  }
}
