/* http://keith-wood.name/keypad.html
   dutch initialisation for the jQuery keypad extension
   Written by Michiel Mussies (mail{at}webcrafts.nl) November 2009. */
(function($) { // hide the namespace
    $.keypad.regional['cn'] = {
        buttonText: '...', buttonStatus: '打开',
        closeText: '关闭', closeStatus: 'Sluit',
        clearText: '清空', clearStatus: 'Wis alle tekens',
        backText: '退格', backStatus: 'Wis laatste teken',
        shiftText: 'Shift', shiftStatus: 'Activeer hoofd-/kleine letters',
		spacebarText: '&nbsp;', spacebarStatus: '',
		enterText: 'Enter', enterStatus: '',
		tabText: '→', tabStatus: '',
        alphabeticLayout: $.keypad.qwertyAlphabetic,
        fullLayout: $.keypad.qwertyLayout,
        isAlphabetic: $.keypad.isAlphabetic,
        isNumeric: $.keypad.isNumeric,
        isRTL: false};
    $.keypad.setDefaults($.keypad.regional['cn']);
})(jQuery);
