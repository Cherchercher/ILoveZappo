# ILoveZappo
Zappos Intern Application

Dear Visitor,
    This readMe.md file contains two parts. Part I is a tutorial about using the ZappoLove App, Part II lists the Modern Design patterns utilized.
    Finally, there is a section about updates that were made since the initial submission of this project.
    
Part I:
    ZappoLove is to build an app that takes input from the user as a search query and returns a list of items with the Zappos Rest API.
    Then user can click on a product of their choie and add it to cart with the option to reverse the action. 

Part II: 
---Databinding for the product page 
---Animation with SplashScreen and Floating Action Button
---Following Material Design guidelines
   • floating action button(margins, depth)
   • primary color, accent color
---Well handled configuration changes
   • onCreate()
   • onClick, onInputChange Listeners
---Using retrofit to handle REST requests

Upadate(s):
  Feb 9: Add handler to Timer to avoid re-initializing timer and memory leaks(http://www.mopri.de/2010/android-memory-leaks/).
