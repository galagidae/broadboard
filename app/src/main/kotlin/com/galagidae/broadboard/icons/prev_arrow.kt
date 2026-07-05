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
public val prev_arrow: ImageVector
  get() {
    if (_prev_arrow != null) {
      return _prev_arrow!!
    }
    _prev_arrow =
      ImageVector.Builder(
          name = "prev_arrow",
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
            moveTo(10f, 22f)
            lineTo(0f, 12f)
            lineTo(10f, 2f)
            lineToRelative(1.78f, 1.77f)
            lineTo(3.55f, 12f)
            lineToRelative(8.23f, 8.23f)
            lineTo(10f, 22f)
            close()
          }
        }
        .build()
    return _prev_arrow!!
  }

private var _prev_arrow: ImageVector? = null
