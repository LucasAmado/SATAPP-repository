package com.gonzaloandcompany.satapp.data.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gonzaloandcompany.satapp.data.repository.JLuisRepository;
import com.gonzaloandcompany.satapp.mymodels.Inventariable;

import java.util.List;

public class JLuisViewModel  extends AndroidViewModel {

    MutableLiveData<List<Inventariable>> inventariables;
    MutableLiveData<List<String>> ubicaciones;
    JLuisRepository repository;
    MutableLiveData<String> idIntervariableSelect;

    public JLuisViewModel(@NonNull Application application) {
        super(application);
        repository = new JLuisRepository();
        idIntervariableSelect = new MutableLiveData<>();
    }

    public MutableLiveData<List<Inventariable>> getAllInventariables() {
        inventariables = repository.getAllInventariable();
        return inventariables;

    }

    public MutableLiveData<List<String>> getAllUbicaciones() {
        ubicaciones = repository.getAllUbicaciones();
        return ubicaciones;

    }

    public void setIdInventariable(String idInventariable) {
        this.idIntervariableSelect.setValue(idInventariable);
    }

    public LiveData<String> getIdInventariable(){
        return idIntervariableSelect;
    }
}
