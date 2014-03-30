(function($) {

  // activate tooltips
  $('[data-toggle="tooltip"]').tooltip();

  // image previewer
  $('.image-previewer').each(function(i, el) {
    var link = $(el).find('.image-input');
    var img = $(el).find('img');
    var fileInput = $(el).find('input[type="file"]');
    var hiddenInput = $(el).find('input[type="hidden"]');
    var removeImage = $(el).find('.remove-image');

    link.click(function(e) {
      e.preventDefault();
      fileInput.one('change', function() {
        if(this.files && this.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            img.attr('src', e.target.result);
            hiddenInput.val("exists");
            removeImage.prop('checked', false);
          }
          reader.readAsDataURL(this.files[0]);
        }
      }).click();
    });

    removeImage.change(function(e) {
      var checked = $(this).prop('checked');
      if(checked) {
        img.data('save', img.attr('src'));
        img.attr('src', img.attr('data-default'));
        hiddenInput.val("");
      } else {
        img.attr('src', img.data('save'));
        hiddenInput.val("exists");
      }
    });
  });

})(jQuery);