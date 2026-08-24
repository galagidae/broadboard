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
public val arrow_left: ImageVector
  get() {
    if (_arrow_left != null) {
      return _arrow_left!!
    }
    _arrow_left =
      ImageVector.Builder(
          name = "arrow_left",
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
            moveTo(10f, 18f)
            lineTo(4f, 12f)
            lineTo(10f, 6f)
            lineToRelative(1.4f, 1.45f)
            lineTo(7.85f, 11f)
            horizontalLineTo(20f)
            verticalLineToRelative(2f)
            horizontalLineTo(7.85f)
            lineToRelative(3.55f, 3.55f)
            lineTo(10f, 18f)
            close()
          }
        }
        .build()
    return _arrow_left!!
  }

private var _arrow_left: ImageVector? = null