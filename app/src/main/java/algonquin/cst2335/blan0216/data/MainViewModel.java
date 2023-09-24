package algonquin.cst2335.blan0216.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import algonquin.cst2335.blan0216.ui.MainActivity;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> editString;

    public MainViewModel(){
        this.editString = new MutableLiveData<String>("");
    }

    public MutableLiveData<String> getEditString(){
        return editString;
    }

    public void setEditString(String editString){
        this.editString.postValue(editString);
    }

    public void observe(MainActivity owner){

        this.editString.observe(owner, new Observer<String>(){

            @Override
            public void onChanged(String s) {

            }
        });

    }

}
