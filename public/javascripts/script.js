(function($) {

  // activate tooltips
  $('[data-toggle="tooltip"]').tooltip();

  // image previewer
  $('.image-previewer').each(function(i, el) {
    var link = $(el).find('.image-input');
    var img = $(el).find('img');
    var input = $(el).find('input[type="file"]');
    var removeImage = $(el).find('.remove-image');
    link.click(function(e) {
      e.preventDefault();
      input.one('change', function() {
        if(this.files && this.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            img.attr('src', e.target.result);
            removeImage.prop('checked', false);
          }
          reader.readAsDataURL(this.files[0]);
        }
      }).click();
    });
    removeImage.change(function(e) {
      var checked = $(this).prop('checked');
      if(checked) {
        img.attr('data-save', img.attr('src'));
        img.attr('src', img.attr('data-default'));
      } else {
        img.attr('src', img.attr('data-save'));
      }
    });
  });

})(jQuery);