// Generated by view binder compiler. Do not edit!
package com.example.m_bora.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.m_bora.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWalletBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView textWallet;

  private FragmentWalletBinding(@NonNull ConstraintLayout rootView, @NonNull TextView textWallet) {
    this.rootView = rootView;
    this.textWallet = textWallet;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_wallet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWalletBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.text_wallet;
      TextView textWallet = ViewBindings.findChildViewById(rootView, id);
      if (textWallet == null) {
        break missingId;
      }

      return new FragmentWalletBinding((ConstraintLayout) rootView, textWallet);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
