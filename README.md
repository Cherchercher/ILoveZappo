# ILoveZappos
Zappos Intern Application

##Part I:Intro:
   ZappoLove is to build an app that takes input from the user as a search query and returns a list of items with the Zappos Rest API.
    Then user can click on a product of their choie and add it to cart with the option to reverse the action. 

##Part II: utilization of Common Design Patterns: 
1) Databinding for the product page <br />
2) Using retrofit to handle REST requests<br />
3) Animation with SplashScreen and Floating Action Button<br />
4) Following Material Design guidelines<br />
   * floating action button(margins, depth)
   * primary color, accent color <br />
5) Well handled configuration changes<br />
   * onCreate(), onCLick()
   * RxAndroid onInputChange 

##Upadate(s):
  Feb 9: Add handler to Timer to avoid re-initializing timer and memory leaks(http://www.mopri.de/2010/android-memory-leaks/).
