/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
	
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.height=280;
	config.width=950;
	config.disableNativeSpellChecker = false;

	/*config.toolbarGroups = [
    { name: 'mode',    groups: [ 'mode'
									//, 'document'
									//, 'doctools' 
									] },
    { name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
    { name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
    { name: 'forms', groups: [ 'TextField', 'Textarea' ] },
    '/',
    { name: 'basicstyles', groups: [ 'basicstyles'
									//, 'cleanup' 
									] },
    
	{ name: 'paragraph',   groups: [ 'list', 'indent'
									//, 'blocks'
									, 'align'
									//, 'bidi' 
									] },
    { name: 'links' },
    { name: 'insert' },
    '/',
    { name: 'styles' },
    { name: 'colors' }
    //,{ name: 'tools' }
    //,{ name: 'others' }
    //,{ name: 'about' }
	];	*/
	//http://ckeditor.com/latest/samples/plugins/toolbar/toolbar.html
	config.toolbar = [
	{ name: 'document', groups: [ 'mode'], items: [ 'Source', '-', 'NewPage','-', 'Templates' ] },
	{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', '-', 'Undo', 'Redo' ] },
	{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ] },
	{ name: 'forms', items: [ 'TextField', 'Textarea','Checkbox','Radio' ] },
	{ name: 'basicstyles', groups: [ 'basicstyles'], items: [ 'Bold', 'Italic', 'Underline'] },
	{ name: 'paragraph', groups: [ 'list', 'indent' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
	'/',
	{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
	{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule','SpecialChar', 'PageBreak' ] },
	{ name: 'styles', items: ['Format', 'Font', 'FontSize' ] },
	{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
	];
};
