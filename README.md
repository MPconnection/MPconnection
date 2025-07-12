<README.md content as inserted above># MPconnection – ClashMeta Config App

این اپلیکیشن اندرویدی با هدف اتصال آسان و امن به سرورهای V2ray/ClashMeta طراحی شده است.  
پیکربندی YAML به صورت خودکار از GitHub دانلود شده، رمزنگاری می‌شود و در اپ اجرا می‌گردد.

---

## 🚀 امکانات:

- اتصال سریع به بهترین سرور از طریق config آماده
- دانلود خودکار فایل YAML از GitHub هر ۲۴ ساعت
- رمزنگاری فایل کانفیگ با امنیت بالا (AES256)
- رابط کاربری مینیمال با وضعیت اتصال و ping زنده
- سازگار با Android 5 به بالا (minSdk 21)

---

## 🔧 ساخت APK (بدون نیاز به Android Studio)

### گزینه ۱: استفاده از [apk-builder.com](https://apk-builder.com)

1. این پروژه را روی GitHub آپلود کنید
2. وارد سایت [https://apk-builder.com](https://apk-builder.com) شوید
3. گزینه **Import from GitHub** را بزنید
4. لینک ریپوی خود را وارد کنید، مثال:
5. 5. نوع build را انتخاب کنید (`Debug` یا `Release`)
6. دکمه Build را بزنید و APK را دانلود کنید

---

## 🔐 امنیت

- فایل clash config پس از دانلود، با AndroidX EncryptedFile رمزنگاری شده و به‌صورت امن ذخیره می‌شود
- MasterKey به‌صورت داخلی تولید شده و نیاز به هیچ رمز خارجی ندارد

---

## 🧩 ساختار فایل‌ها

| فایل | توضیح |
|------|-------|
| `MainActivity.kt` | صفحه اصلی اپ با رابط کاربری ساده |
| `ConfigSync.kt` | دانلود و کش‌کردن فایل YAML از GitHub |
| `EncryptedStorage.kt` | رمزنگاری/خواندن فایل config |
| `AndroidManifest.xml` | معرفی ساختار اپ به اندروید |
| `build.gradle` | تنظیمات پروژه برای build |
| `README.md` | مستندات پروژه |

---

## 🆘 پشتیبانی

برای هرگونه سوال، پیشنهاد یا توسعه بیشتر، از طریق issues در GitHub یا پیام مستقیم اقدام کنید.

با عشق ❤️ توسط Mahdi و کمک ChatGPT توسعه یافته است.
