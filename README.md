# ILoveZappos
Zappos Intern Application

##Part I:Intro:
   ZappoLove is an Android Application that takes input from the user as a search query and returns a list of items with the Zappos Rest API.
   Users can then click on a product of their choice and add it to cart( with the option to reverse the action). 

##Part II: utilization of Common Design Patterns: 
1) Databinding for the product page <br />
2) Using retrofit to handle REST requests<br />
5) Well handled configuration changes<br/>
   * onCreate(), onCLick()
   * RxJava onInputChange

<br/>3) Animation with SplashScreen and Floating Action Button<br />
4) Following Material Design guidelines
   * floating action button(margins, depth)
   * primary color, accent color

##Upadate(s):
  Feb 9: Add handler to Timer to avoid re-initializing timer and memory leaks(http://www.mopri.de/2010/android-memory-leaks/).
