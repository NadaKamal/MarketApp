package com.example.market.ui.settings;

import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.market.LocaleHelper;
import com.example.market.R;
import com.example.market.databinding.FragmentAddressToDeliverBinding;
import com.example.market.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {

    private SettingViewModel mViewModel;
    FragmentSettingBinding binding;
    int selected;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSettingBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isFromSetting", true);
                Navigation
                        .createNavigateOnClickListener(R.id.action_navigation_setting_to_signUpFragment,bundle)
                        .onClick(v);
            }
        });

        binding.tvMyAddresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isFromSetting", true);
                Navigation
                        .createNavigateOnClickListener(R.id.action_navigation_setting_to_addressToDeliverFragment,bundle)
                        .onClick(v);
            }
        });

        binding.tvLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        binding.tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Navigation.findNavController(v).navigate(R.id.action_navigation_setting_to_aboutAppFragment);
            }
        });

        binding.tvPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_setting_to_privacyPolicyFragment);

            }
        });

    }

    private void showAlertDialog() {

        final Dialog dialog = new Dialog(getActivity(), R.style.CustomAlertDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.choose_language_dialog);
        Button btnConfirm = dialog.findViewById(R.id.btn_confirm);
        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        final RadioGroup radioGroupLang = dialog.findViewById(R.id.radio_group_lang);
        final RadioButton radioButtonAr = dialog.findViewById(R.id.radio_arabic);
        final RadioButton radioButtonEn = dialog.findViewById(R.id.radio_english);

               radioGroupLang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(RadioGroup group, int checkedId) {
                       if (checkedId == R.id.radio_arabic)
                       {
                           Context context = LocaleHelper.setLocale(getActivity(), "ar");
                           selected = 1;
                       }
                       else if (checkedId == R.id.radio_english)
                       {
                           Context context = LocaleHelper.setLocale(getActivity(), "en");
                          selected = 2;
                       }
                   }

               });


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                getActivity().recreate();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
        dialog.show();

    }


}