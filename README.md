# EasySampleInflater

1. Inflaterとは？？
直訳=> 他:膨らませる　自:膨らむ
膨らませるイメージを持っていれば良さそう。

公式ドキュメント
```
Instantiates a layout XML file into its corresponding View objects. It is never used directly. Instead, use Activity.getLayoutInflater() or Context#getSystemService to retrieve a standard LayoutInflater instance that is already hooked up to the current context and correctly configured for the device you are running on.

To create a new LayoutInflater with an additional Factory for your own views, you can use cloneInContext(Context) to clone an existing ViewFactory, and then call setFactory(LayoutInflater.Factory) on it to include your Factory.

For performance reasons, view inflation relies heavily on pre-processing of XML files that is done at build time. Therefore, it is not currently possible to use LayoutInflater with an XmlPullParser over a plain XML file at runtime; it only works with an XmlPullParser returned from a compiled resource (R.something file.)

Note: This class is not thread-safe and a given instance should only be accessed by a single thread.
```
さくっと要点を直訳
- 対応するViewオブジェクトのなかにlayout XMLを表示する際、XMlファイルは直接使われない。代わりに、
```
Activity.getLayoutInflater()  
Context#getSystemService
```
これらのどちらかを使う。
- 2文目。factoryがプロジェクトと読み替えて良いのかな？まあ、2つのメソッドを使え的な話し。クローンするらしい。
- 3文目。inglaterはパフォーマンス的に、XMLファイルがビルド時行う過程に大きく依存する。だから、ただのxmlファイルに対してLayoutInflaterとXmlPullParserを使うのは現状では不可能ですよって話。LayoutInflaterは、AmlPullParserがコンパイルされたレスースから戻されたときに飲み働くらしい。つまり、働く順序があるから同時に使うことができないよねってことでOKっぽい。


気づいてしまった。これがやっているのって、あらかじめ作ってあるレウアウトを再利用したいぞ！よし！インスタンス化しちゃえば良いじゃん！あれれ、インスタンス化はしちゃいけないみたいだ！なになに？代わりにActivity.getLayoutInflaterかContext#getSYstemServiceを使えば良いらしいぞ！なんでかはわからんけども。。。ここの深掘りは実務でやれば良きです。。


2. 実際に写経してみてそれっぽいものを作ってみる。



