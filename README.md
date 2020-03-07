# MyImageLoader
I'm rubbish
## How to use
- load one image
---
```
MyImageLoader myImageLoader = new MyImageLoader(this);
//myImageLoader.useCache(true);
myImageLoader.setHandler(handler).setTaskNumber(1).setURL(URL).load();
```
- load many images
  
  you need a String[] to save URLs;
---
```
MyImageLoader myImageLoader = new MyImageLoader(this);
//myImageLoader.useCache(true);
myImageLoader.setHandler(handler).setTaskNumber(1).setMaxThread(30);
        for (int i = 0; i < imageUrls.length; i++) {
            myImageLoader.loads(imageUrls[i]);
        }
```
## Now bug
- If URL from last 9 to 5,maybe using cache in loading many images will have bug.
