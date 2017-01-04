package com.rogek.typlingo;

import android.graphics.Canvas;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import java.util.concurrent.ConcurrentHashMap;


public class MyKeyboard extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener{

    private static final int KEYBOARD_ENG = -446 ;
    private static final int KEYBOARD_HEB = -444 ;
    private static final int KEYBOARD_SYM = -445 ;

    private KeyboardView kv;
    private Keyboard heb_keyboard;
    private Keyboard eng_keyboard;
    private Keyboard sym_keyboard;

    private boolean caps = false;
    private boolean isHeb , isEng , isDigit ;

    private ConcurrentHashMap<String,Boolean> badWords = null;

    StringBuffer input = new StringBuffer();

    @Override
    public View onCreateInputView() {

        badWords = BadWordsHandler.getInstance().getMap();
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);

        //Initializing Both heb&eng keyboard - but as default the hebrew keyboard
        //will be viewed
        heb_keyboard = new Keyboard(this, R.xml.heb_keys);
        eng_keyboard = new Keyboard(this, R.xml.qwerty);
        sym_keyboard = new Keyboard(this, R.xml.symbols);

        kv.setKeyboard(eng_keyboard);

        kv.setOnKeyboardActionListener(this);

        isHeb = true;
        return kv;
    }

    private void playClick(int keyCode){
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        switch (keyCode) {
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }


    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting){
        input.setLength(0);
    }

    @Override
    public void onFinishInput(){
        input.setLength(0);
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {

        try
        {
            //Getting the Letters from the Unicode class
            // If we are writing in hebrew then we need to match each letter to its accordingly output.
            String text = Unicode.getInstance().getUnicode(primaryCode);
            if(text.equals("null"))
                text = String.valueOf((char) primaryCode);


            if (caps){
                text = text.toUpperCase();
            }
            InputConnection ic = getCurrentInputConnection();
            playClick(primaryCode);

            switch (primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    ic.deleteSurroundingText(1, 0);
                    if(input.length() > 0)
                        input.deleteCharAt(input.length()-1);
                    break;
                case Keyboard.KEYCODE_SHIFT:
                    caps = !caps;
                    eng_keyboard.setShifted(caps);
                    kv.invalidateAllKeys();
                    break;
                case Keyboard.KEYCODE_DONE:
                    ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case KEYBOARD_SYM:
                    System.out.println("Keyboard Pressed Symbols Changed");
                    kv.setKeyboard(sym_keyboard);
                    break;
                case KEYBOARD_HEB:
                    System.out.println("Keyboard Pressed Hebrew Changed");
                    kv.setKeyboard(heb_keyboard);
                    break;
                case KEYBOARD_ENG:
                    System.out.println("Keyboard Pressed English Changed");
                    kv.setKeyboard(eng_keyboard);
                    break;
                default:

                    //adding text into the stringBuffer
                    input.append(text);

                    System.out.println("Input is \t" + input.toString());
                    System.out.println("Input Length is \t" + input.length());
                    if(text.equals(" ") && input.length()>1){
                        input.delete(0,input.length());
                    }


                    if (input.toString().contains("זונה") || input.toString().contains("בת זונה")) {
                        System.out.println("YESYES");
                        ic.deleteSurroundingText(input.length() - 1, 0);
                        input.setLength(0);
                        ic.commitText("", 1);
                        break;
                    }

                    String test = input.toString().replaceAll("([^aA-zZ\\u0590-\\u05fe])", "");

                    if (badWords.containsKey(test.toLowerCase())){
                        System.out.println("YES IN MAP");
                        ic.deleteSurroundingText(input.length() - 1, 0);
                        input.setLength(0);
                        ic.commitText("", 1);
                        break;
                    }

                    ic.commitText(text, 1);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onText(CharSequence text) {
        handleInput();
//        Thread thread = new Thread(){
//            public void run(){
//                while(true){
//                    try {
//
//                    }
//                    catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                }
//            }
//        };
    }

    private void handleInput(){
        String [] str = input.toString().split(" ");
        for (int i=0; i<str.length;i++){
            if(badWords.containsKey(str[i].toLowerCase())){
                int start = input.indexOf(str[i]);
                int end = start+str[i].length();
                input.delete(start,end);
            }
        }
        System.out.println(input);
    }


    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }


//    @Override
//    public void onDraw(Canvas canvas) {
//        // super.onDraw(canvas);
//
//        List<Key> keys = getKeyboard().getKeys();
//        for (Key key : keys) {
//            if (key.codes[0] == 7) {
//                NinePatchDrawable npd
//                        = (NinePatchDrawable) context.getResources().getDrawable(R.drawable.red_key);
//                npd.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
//                npd.draw(canvas);
//
//            } else {
//                NinePatchDrawable npd
//                        = (NinePatchDrawable) context.getResources().getDrawable(R.drawable.blue_key);
//                npd.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
//                npd.draw(canvas);
//            }
//
//            Paint paint = new Paint();
//            paint.setTextAlign(Paint.Align.CENTER);
//            paint.setTextSize(48);
//            paint.setColor(Color.GRAY);
//
//            if (key.label != null) {
//                canvas.drawText(key.label.toString(), key.x + (key.width / 2),
//                        key.y + (key.height / 2), paint);
//            } else {
//                key.icon.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
//                key.icon.draw(canvas);
//            }
//        }
//    }


}

