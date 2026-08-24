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
public val arrow_right_double: ImageVector
  get() {
    if (_arrow_right_double != null) {
      return _arrow_right_double!!
    }
    _arrow_right_double =
      ImageVector.Builder(
          name = "arrow_right_double",
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
            moveTo(9.58f, 12f)
            lineTo(5f, 7.4f)
            lineTo(6.4f, 6f)
            lineToRelative(6f, 6f)
            lineToRelative(-6f, 6f)
            lineTo(5f, 16.6f)
            lineTo(9.58f, 12f)
            close()
            moveToRelative(6.6f, 0f)
            lineTo(11.6f, 7.4f)
            lineTo(13f, 6f)
            lineToRelative(6f, 6f)
            lineToRelative(-6f, 6f)
            lineTo(11.6f, 16.6f)
            lineTo(16.18f, 12f)
            close()
          }
        }
        .build()
    return _arrow_right_double!!
  }

private var _arrow_right_double: ImageVector? = null
