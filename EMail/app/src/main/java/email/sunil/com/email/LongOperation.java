package email.sunil.com.email;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class LongOperation extends AsyncTask<Void, Void, String> {
	
	String to,sub,msg ;
	 String[] mailid;
	 String text;
	
	public LongOperation(String to, String sub, String msg) {
	
/*

						this.to=to;
						this.sub=sub;
						this.msg=msg;	
*/

	}




	@Override
	protected String doInBackground(Void... params) {
		mailid=MainActivity.mainActivity.getResources().getStringArray(R.array.mails);
		text=MainActivity.mainActivity.getResources().getString(R.string.text);
   for(int i=0;i<mailid.length;i++) {

	   try {
		   GMailSender sender = new GMailSender("satvalentineday14feb@gmail.com", "wecando12345");
		   sender.sendMail("Happy Valentines Day", text, mailid[i], mailid[i]);
		   //		Toast.makeText(MainActivity.mainActivity,"Sent",Toast.LENGTH_LONG).show();
	   } catch (Exception e) {
		   Log.e("error", e.getMessage(), e);
		   return "Email Not Sent";
	   }
   }
		return "Email Sent"; 
	} 
	
	
	

	@Override
	protected void onPostExecute(String result) 
	{
	}
	@Override
	protected void onPreExecute() 
	{
	}
	
	@Override
	protected void onProgressUpdate(Void... values) 
	{
	}
}