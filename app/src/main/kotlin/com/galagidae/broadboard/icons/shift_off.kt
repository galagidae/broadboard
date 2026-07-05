package com.galagidae.broadboard.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val shift_off: ImageVector
  get() {
    if (_shift_off != null) {
      return _shift_off!!
    }
    _shift_off =
      ImageVector.Builder(
          name = "shift_off",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Bevel,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.Companion.NonZero,
          ) {
            moveTo(8f, 21f)
            verticalLineTo(13f)
            horizontalLineTo(3f)
            lineTo(12f, 2f)
            lineToRelative(9f, 11f)
            horizontalLineTo(16f)
            verticalLineToRelative(8f)
            horizontalLineTo(8f)
            close()
            moveToRelative(2f, -2f)
            horizontalLineToRelative(4f)
            verticalLineTo(11f)
            horizontalLineToRelative(2.78f)
            lineTo(12f, 5.15f)
            lineTo(7.23f, 11f)
            horizontalLineTo(10f)
            verticalLineToRelative(8f)
            close()
            moveToRelative(2f, -8f)
            close()
          }
        }
        .build()
    return _shift_off!!
  }

private var _shift_off: ImageVector? = null