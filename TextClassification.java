public class TextClassificationClient {
  //...
  /** Classify an input string and returns the classification results. */  
  public synchronized List<Result> classify(String text) {
    //...
    // Find the best classifications.
    PriorityQueue<Result> pq =
        new PriorityQueue<>(
            MAX_RESULTS, (lhs, rhs) -> Float.compare(rhs.getConfidence(), lhs.getConfidence()));
    //edit
    pq.add(new Result("" + 1, labels.get(1), output[0][1]));
    /*
    for (int i = 0; i < labels.size(); i++) {
      pq.add(new Result("" + i, labels.get(i), output[0][i]));
    }
    */
    //...
  }  
}
view rawTextClassificationClient.java hosted with ❤ by GitHub

ChatFragment.java
public class ChatFragment extends Fragment implements View.OnClickListener, TextWatcher {
  private RecyclerView mMessagesList;
  //...
  //Part2: Generate Emojis according to threshold
  private void showResult(final String inputText, final List<Result> results) {
        if (results != null) {
            //retrieves the positive confidence only
            Result result = results.get(0);

            String emoj ="";
            if (result.getConfidence() > 0.8) { emoj = "YOUR EMOJIs GO HERE"; }
            else if (result.getConfidence() > 0.6) { emoj = "YOUR EMOJIs GO HERE"; }
            else if (result.getConfidence() > 0.4) { emoj = "YOUR EMOJIs GO HERE"; }
            else if (result.getConfidence() > 0.2) { emoj = "YOUR EMOJIs GO HERE"; }
            else { emoj = "YOUR EMOJIs GO HERE"; }

            sendMessage(inputText + emoj);
        }
    }
  //...
