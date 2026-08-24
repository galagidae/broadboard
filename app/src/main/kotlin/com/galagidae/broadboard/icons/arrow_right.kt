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
public val arrow_right: ImageVector
  get() {
    if (_arrow_right != null) {
      return _arrow_right!!
    }
    _arrow_right =
      ImageVector.Builder(
          name = "arrow_right",
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
            moveTo(14f, 18f)
            lineTo(12.6f, 16.55f)
            lineTo(16.15f, 13f)
            horizontalLineTo(4f)
            verticalLineTo(11f)
            horizontalLineTo(16.15f)
            lineTo(12.6f, 7.45f)
            lineTo(14f, 6f)
            lineToRelative(6f, 6f)
            lineToRelative(-6f, 6f)
            close()
          }
        }
        .build()
    return _arrow_right!!
  }

private var _arrow_right: ImageVector? = null