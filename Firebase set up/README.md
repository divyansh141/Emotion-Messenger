# Add Firebase to Emotion Messenger Project

# Set up Firebase
# Prerequisites
Sign into Firebase using your Google account.
If you don't already have a project and just want to try out a Firebase product, you can download one of the quickstart samples.

# Step 1: Create a Firebase project and connect with your app
Create a Firebase project 

In the Firebase console, click Add project, then select or enter a Project name.
![Az Community (New Logo) Blue](https://github.com/AIBrainAISchool/Emotion-Messenger/blob/main/Firebase%20set%20up/Screenshot%20(283).png)
-If you have an existing Google Cloud project, you can select the project from the dropdown menu to add Firebase resources to that project.

-Firebase automatically assigns a unique ID 

-Click Continue.

Configure Google Analytics=>  Choose or create a Google Analytics account => Default account for firebase => Click Create project (or Add Firebase, if you're using an existing Google Cloud project).

# Step 2: Register your app with Firebase
![Firebase Blue](https://github.com/AIBrainAISchool/Emotion-Messenger/blob/main/Firebase%20set%20up/Screenshot%20(284).png)

# Register app
1.In the center of the Firebase console's  click the android icon and launch setup workflow.

2.Android package name in box.

3.Enter your app's nickname(nickname is an internal, convenience identifier and is only visible to you) 

4.Register app.

#Download config file

-Download json file

Click on Next

# Add firebase SDK
1.Click on Next

2.Continue to console
 
 
 
 
Authentication needed

After registering you are on the console page on the left side of the window 
![ Firebase Blue](https://github.com/AIBrainAISchool/Emotion-Messenger/blob/main/Firebase%20set%20up/Untitled%20design.png)
1.Click on Build -> Authentication -> Click on Get started you will be able to see many such options for authentication (email,twitter etc) from which you want to authenticate

2.Click Email/Password => Enable on =>save

# Realtime Database
1.Click on Build  ->Realtime Database -> Click on Create Database

2.Choose Your location setting is where your Realtime Database data will be stored

3. click on enable  
 
 Storage

1.Click in  Build-> Storage->Get started -> CLick on Done
Open https://console.cloud.google.com/

2.Click on Select project on top ->In Dialog box click on All => Select your project

3.Click on navigation bar -> Scroll it>In  Database click on Datastore>Click on Switch to Navigate Mode 

4.Click on got it you will move to Firestore                                                                                                              

5.Close the window


# Upgrade
![ Firebase Blue](https://github.com/AIBrainAISchool/Emotion-Messenger/blob/main/Firebase%20set%20up/Firebase.png)

1.Come on above  page in Right corner click on upgrade two option will come

2. click on pay as you go

3.SelectDialog box will show your will account Click on Firebase pay  

4. continue 

5.Purchase-Set a budget alert- Set your budget (it can be minimum)
 
 
 
# The final objective of this lab is to have the messenger app  make sentiment predictions on outgoing messages you've already seen a sentiment analysis  model with the twitter airline dataset  this time you will apply a model to the messenger app so it will generate relevant emoji  depending on the sentiment score of some  so first we will look for a sentiment  analysis model preferably  export for natural language models at the moment so we will just grab a pre-trained model   we can use what the search engine has to offer us sentiment analysis and remodel scroll down and find text classification sample from tensorflow and this demo offers a pre-trained model that predicts if a paragraph sentiment is positive or negative it is trained on shoping  data sets  

![ Firebase Blue](https://github.com/AIBrainAISchool/Emotion-Messenger/blob/main/Firebase%20set%20up/Screenshot%20(287).png)
see a 
example cases let's check it for ourselves there is an android example  

1.just click examples here on the top and
 
2.download the whole repository
 
3.unzip the file
 
4.light examples we want to try text classification and find android
 
5.Now turn on android studio  and drag and drop the folder this is a simple demo app that has one activity  on the emulator to see how it goes start with something nice yes and  positive something bad this time and yes that was quite negative something short

how about this  can see some issues here try a different word  testing will tell that since this was streamed on a movie review data  Set it is not super for

Search analyzing sentiment -(https://www.tensorflow.org/lite/examples/text_classification/overview)
will see how the classification result is displayed the app is quite well annotated too and this is always a good practice to annotate your code so you can share it with others so the annotation indicates that this is  the code for displaying the results each prediction result starts with inputs and the text itself which is input text change line and then output change line and there's a for loop here that seems to retrieve the prediction title and confidence rate title is 
# Tensorflow >Andriod example 
https://github.com/tensorflow/examples/tree/master/lite/examples/text_classification/android 
# Click on code > Download Zip file >Extract the zip file > open lite folder > open expiremental folder  > Text classification > open android studio > open exiting project > Select the file and open > Run it > Your Emulator will run 

And  positive and negative and the confidence rate and it finishes off with dashes and then right above the code  block that displays the results is the code that sends the text for prediction  time to see where we need to edit in the messenger app template file you will see where we need to fix in the messenger app template
there are a lot of java files in this
template to look through but we only want access to the actual chat feature of the app you want to have access to what the user is typing and generate a prediction out of that one way to look for the relevant piece of code is to look at the names of the java files however this may be difficult if the names of the files are not well Organized another approach is to look at the design file
in the resource folder down on the left go to the layout folder here you can see all the design pages of  the app by sifting through these you can guess where the relevant codes are locate for example here in the activity account xml


Files  can see that fragmentchat.xml is the screen you are looking for below here is the text box where i type messages and the send button the middle here are the conversation history with username at the top now if i find where the send button or the text box is being used inside the code i can find the code that i want to edit  go to the top right and click split you can see the xml beyond the design by clicking on the design element you can also locate the id of the element the one we want to look for is where the message text box and send button is being used the id for the send button is in  underscore sent this id is being used somewhere in the  code to send messages right click and click find usages a frame should pop up indicating all the usage of the send button there is a usage inside the xml and below here is the resource reference in the codes

The first one just allocates the button

At the second reference double click and we are here this is at chatfragment.java

At the button is being used when the button is clicked message takes the value inside and message box let's see what m message box is then find usages and it looks like m message box 

Actually the  underscore message underscore box if you double click now this design element is actually the message box we saw earlier let's head back so the message takes the value of whatever text inside the message box

Then there is a if statement the exclamation mark inside here actually means the opposite of whatever is inside
so that means if the message is not empty send message and then empty the message text box which is exactly what happens when we use messenger apps so this piece of code right here is what we need to work on to perform a sentiment analysis prediction on the  Message a tip here since we are going to come back to this piece of code  frequently you can also bookmark this by  going to navigate bookmarks toggle bookmarks with mnemonic if you do this you can set a shortcut key to this specific point of code
 

 

