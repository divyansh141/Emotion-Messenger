public class ChatFragment extends Fragment implements View.OnClickListener, TextWatcher {
  private RecyclerView mMessagesList;
  
  //...
  //Define handler, client, and textToShow
  private Handler handler;
  private TextClassificationClient client;
  private String textToShow;
  
  public ChatFragment() {
  }
  //...
  
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    //...
    //initialize handler and client
    handler = new Handler();
    client = new TextClassificationClient(activity);
    //...
  }
  
  //...
  //Setup handler
  @Override
    public void onStart() {
        super.onStart();
        Log.v("handler", "onStart");
        handler.post(
                () -> {
                    client.load();
                });
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("handler", "onStop");
        handler.post(
                () -> {
                    client.unload();
                });
    }

    /** Send input text to TextClassificationClient and get the classify messages. */
    private void classify(final String text) {
        handler.post(
                () -> {
                    // Run text classification with TF Lite.
                    List<Result> results = client.classify(text);

                    // Show classification result on screen
                    showResult(text, results);
                });
    }

    //Part1: Show Positive and Negative prediction result
    private void showResult(final String inputText, final List<Result> results) {
      if (results != null) {
        textToShow = "";
        for (int i = 0; i < results.size(); i++) {
          Result result = results.get(i);
          textToShow += String.format("\n%s: %s", result.getTitle(), result.getConfidence());
        }
        sendMessage(inputText + textToShow);
      }
    }
        

    //Classify message
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send: {
                String message = mMessageBox.getText().toString();
                if (!message.trim().isEmpty()) {
                    //edit
                    classify(mMessageBox.getText().toString());
                    //sendMessage(message);
                    mMessageBox.setText(null);
                    break;
                }
            }
            //...
        }
    }
  //...
}
