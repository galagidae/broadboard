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
public val arrow_left_double: ImageVector
  get() {
    if (_arrow_left_double != null) {
      return _arrow_left_double!!
    }
    _arrow_left_double =
      ImageVector.Builder(
          name = "arrow_left_double",
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
            moveTo(11f, 18f)
            lineTo(5f, 12f)
            lineTo(11f, 6f)
            lineToRelative(1.4f, 1.4f)
            lineTo(7.83f, 12f)
            lineToRelative(4.58f, 4.6f)
            lineTo(11f, 18f)
            close()
            moveToRelative(6.6f, 0f)
            lineToRelative(-6f, -6f)
            lineToRelative(6f, -6f)
            lineTo(19f, 7.4f)
            lineTo(14.43f, 12f)
            lineTo(19f, 16.6f)
            lineTo(17.6f, 18f)
            close()
          }
        }
        .build()
    return _arrow_left_double!!
  }

private var _arrow_left_double: ImageVector? = null
