# AppUtilsLibrary
AppUtilsLibrary is a fast and efficient open source. Apputilus is a library with many classes that we use regularly.


<h2><a id="user-content-how-do-i-use-glide" class="anchor" aria-hidden="true" href="#how-do-i-use-glide"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Kotlin class:</h2>

<ul>

<li> CameraGalleryUtils</li>
<li>  CompressFileUtils</li>
<li>  FileHelperUtils</li>
<li>  PermissionUtils</li>
<li>  DialogUtil</li>
<li>  EditTextUtils</li>
<li>  GeneralAppUtils</li>
<li>  IsEmpty</li>
<li>  KeyBordUtils</li>
<li>  LayoutUtils</li>
<li>  LogsUtils</li>
<li>  NetworkUtils</li>
<li>  NotificationUtils</li>
<li>  PreferenceUtils</li>
<li>  RegularExpression</li>
<li>  TextViewUtils</li>
<li>  TimeUtil</li>
</ul>

<h2><a id="user-content-download" class="anchor" aria-hidden="true" href="#download"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Download</h2>
<p>You can download a jar from GitHub's <a href="https://github.com/MohsinaliEMed/AppUtilsLibrary/releases/">releases page</a>.</p>
<p>Or use Gradle:</p>
<div class="highlight highlight-source-groovy-gradle"><pre><span class="pl-en">allprojects</span> {
 &nbsp;repositories  {
         ...
         maven { url 'https://jitpack.io' }
         }
}

<span class="pl-en">dependencies</span> {
&nbsp;implementation <span class="pl-s"><span class="pl-pds">'</span>com.github.MohsinaliEMed:AppUtilsLibrary:1.0.1<span class="pl-pds">'</span></span>
}</pre></div>


<h2><a id="user-content-how-do-i-use-glide" class="anchor" aria-hidden="true" href="#how-do-i-use-glide"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>How do I use AppUtilsLibrary?</h2>

<p>Simple use cases will look something like this:</p>

```Kotlin
 // For a simple view for Check Network connection:
 isNetworkConnected(context,"Internet not connected")

 // For a simple image list we use Glide:
 val imageView: ImageView = findViewById<View>(R.id.my_image_view) as ImageView
 LayoutUtils.setImageView(mContext, ImageView,imgViewLoadUrl,R.drawable.loading_spinner,R.drawable.img_error)
 
 // For Round Set Image
 LayoutUtils.setImageViewRounded(mContext, ImageView,imgViewLoadUrl,R.drawable.loading_spinner,R.drawable.img_error)

 // For show msg on Logcat
 LogsUtils.showError(tagValues,tagName,buildType)
 
 // For Tost Message
 LogsUtils.showToast(context,"Hello World")
 
```
