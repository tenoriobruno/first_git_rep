package estacioneAki.servico;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import estacioneAki.util.EstacionamentoList;
import estacioneAki.util.Retorno;
import android.os.AsyncTask;
import android.util.Log;

public class getRespostaFromWSVerifcaReserva extends AsyncTask<String, Void , String>{        
	private String MsgParaTela = null;    	 	
	private Retorno mensagem = null;
	
	@Override 
    protected String doInBackground(String... UrlListaEstacionamentos) { 

 		try {
 			URL myURL = new URL(UrlListaEstacionamentos[0]); 	 				 		 	
			URLConnection ucon2 = myURL.openConnection();   	 			  	 			 
 			InputStream is2 = ucon2.getInputStream();
			Serializer serializer2 = new Persister();
			
			mensagem = serializer2.read(Retorno.class, is2);
			Log.v("Clase getRespostaFromWSVerificaReserva", "msg:"+mensagem.getMensagem());
			MsgParaTela = mensagem.getMensagem(); 			
		}
		catch (Exception e){
			e.printStackTrace();
		    Log.v("Clase getRespostaFromWSVerificaReserva", "VerificaReservaFalse "+mensagem.getMensagem());
		} 			
	 
        return MsgParaTela;   
     } 
     
     protected void onPostExecute(String msgParaTela) {     	 
    	 Log.v("Clase getRespostaFromWSVerficaReserva-posexecute", mensagem.getMensagem());     	 
     } 
} 