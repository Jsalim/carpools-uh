(function($) {

  // activate tooltips
  $('[data-toggle="tooltip"]').tooltip();

  // image previewer
  $('.image-input').click(function(e) {
    e.preventDefault();
    var img = $(this).find('img');
    var target = $(this).attr('data-target');
    $(target).one('change', function(e) {
      if(this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
          img.attr('src', e.target.result);
        }
        reader.readAsDataURL(this.files[0]);
      }
    }).click();
  });

})(jQuery);