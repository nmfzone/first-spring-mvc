var gulp       = require('gulp'),
    gutil      = require('gulp-util'),
    jshint     = require('gulp-jshint'),
    sass       = require('gulp-sass'),
    concat     = require('gulp-concat'),
    sourcemaps = require('gulp-sourcemaps'),
    flatten    = require('gulp-flatten'),
    imagemin   = require('gulp-imagemin'),

    input = {
      'stylesheets': 'frontend/assets/css/**/*.css',
      // 'javascript' : 'frontend/assets/js/**/*.js',
      // 'scss'       : 'frontend/assets/scss/**/*.scss',
      // 'fonts'      : 'frontend/assets/fonts/*',
      // 'images'     : 'frontend/assets/images/*',
      'vendorcss'     : 'frontend/assets/vendor/**/dist/**/*.min.css',
      'vendorjs'      : 'frontend/assets/vendor/**/dist/**/*.min.js',
      'vendorfonts'   : 'frontend/assets/vendor/**/dist/fonts/*'
    },

    output = {
      'stylesheets': 'src/main/resources/static/assets/css',
      'javascript' : 'src/main/resources/static/assets/js',
      'fonts'      : 'src/main/resources/static/assets/fonts',
      // 'images'     : 'src/main/resources/static/assets/images'
    };

// gulp.task('default', ['watch']);

gulp.task('build',
          [
            'build-css',
            // 'build-js',
            // 'build-scss',
            // 'build-fonts',
            // 'build-images',
            'build-vendor-css',
            'build-vendor-fonts',
            'build-vendor-js'
          ]
);

// gulp.task('jshint', function() {
//   return gulp.src(input.javascript)
//   .pipe(jshint())
//   .pipe(jshint.reporter('jshint-stylish'));
// });

gulp.task('build-css', function() {
  return gulp.src(input.stylesheets)
  .pipe(sourcemaps.init())
  .pipe(sourcemaps.write())
  .pipe(flatten())
  .pipe(gulp.dest(output.stylesheets));
});

// gulp.task('build-js', function() {
//   return gulp.src(input.javascript)
//   .pipe(sourcemaps.init())
//   .pipe(gutil.env.type === 'production' ? uglify() : gutil.noop())
//   .pipe(sourcemaps.write())
//   .pipe(flatten())
//   .pipe(gulp.dest(output.javascript));
// });

// gulp.task('build-scss', function() {
//   return gulp.src(input.scss)
//   .pipe(sourcemaps.init())
//   .pipe(sass())
//   .pipe(sourcemaps.write())
//   .pipe(flatten())
//   .pipe(gulp.dest(output.stylesheets));
// });

// gulp.task('build-fonts', function() {
//   return gulp.src(input.fonts)
//   .pipe(sourcemaps.init())
//   .pipe(sourcemaps.write())
//   .pipe(flatten())
//   .pipe(gulp.dest(output.stylesheets));
// });

// gulp.task('build-images', function() {
//   return gulp.src(input.images)
//   .pipe(sourcemaps.init())
//   .pipe(imagemin({
//       progressive: true
//   }))
//   .pipe(sourcemaps.write())
//   .pipe(flatten())
//   .pipe(gulp.dest(output.images));
// });

gulp.task('build-vendor-css', function() {
  return gulp.src(input.vendorcss)
  .pipe(sourcemaps.init())
  .pipe(sourcemaps.write())
  .pipe(flatten()) //remove the bower_components relative path
  .pipe(gulp.dest(output.stylesheets));
});

gulp.task('build-vendor-fonts', function() {
  return gulp.src(input.vendorfonts)
  .pipe(sourcemaps.init())
  .pipe(sourcemaps.write())
  .pipe(flatten())
  .pipe(gulp.dest(output.fonts));
});

gulp.task('build-vendor-js', function() {
  return gulp.src(input.vendorjs)
  .pipe(sourcemaps.init())
  .pipe(sourcemaps.write())
  .pipe(flatten())
  .pipe(gulp.dest(output.javascript));
});

// gulp.task('watch', function() {
//   gulp.watch(input.stylesheets, ['build-css']);
//   gulp.watch(input.javascript, ['jshint', 'build-js']);
//   gulp.watch(input.sass, ['build-sass']);
//   gulp.watch(input.fonts, ['build-fonts']);
//   gulp.watch(input.images, ['build-images']);
// });
