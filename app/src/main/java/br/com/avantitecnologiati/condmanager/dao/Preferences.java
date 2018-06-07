package br.com.avantitecnologiati.condmanager.dao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import br.com.avantitecnologiati.condmanager.app.LoginActivity;
import br.com.avantitecnologiati.condmanager.dao.Database;
import br.com.avantitecnologiati.condmanager.dao.SindicoRecord;
import br.com.avantitecnologiati.condmanager.model.Sindico;

public class Preferences {
        private SharedPreferences preferences;
        private  final String NOME_ARQUIVO = "login.preferencias";
        public  final int MODE = 0;
        private SharedPreferences.Editor editor;
        private Context contexto;

        public Preferences(Context context) {
            this.contexto =  context;
            preferences = this.contexto.getSharedPreferences(NOME_ARQUIVO,MODE);
            this.editor = preferences.edit();
        }

        /**
         *
         * @return as prefencias
         */
        public SharedPreferences getPreferences() {
            return preferences;
        }

        /**
         *
         * @param email
         */
        public void salvarUsuario(String email){
            editor.putString("email",email);
            editor.commit();
        }

        /**
         *
         * @return o email do usuário
         */
        public String getEmailUsuarioLogado(){
           String email  = this.preferences.getString("email",null);
            return  email;
        }

        /**
         *
         * @return retorna verdadeiro caso exista um id;
         */
        public boolean logado(){
            return !getEmailUsuarioLogado().trim().isEmpty();
        }


        /**
         * limpa as preferencias e redirenciona para tela de login
         */
        public void logout() {

            editor.clear();
            editor.commit();
            contexto.startActivity(new Intent(contexto.getApplicationContext(), LoginActivity.class));
            ((Activity)contexto).finish();
        }


        public Sindico getUsuarioLogado () {
            SindicoRecord sindicoRecord = new SindicoRecord(new Database(this.contexto));
            return logado() ? sindicoRecord.getObject(getEmailUsuarioLogado(),null) : null;
        }

}
