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
public val enter: ImageVector
  get() {
    if (_enter != null) {
      return _enter!!
    }
    _enter =
      ImageVector.Builder(
          name = "keyboard_return",
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
            moveTo(9f, 18f)
            lineTo(3f, 12f)
            lineTo(9f, 6f)
            lineToRelative(1.4f, 1.4f)
            lineTo(6.8f, 11f)
            horizontalLineTo(19f)
            verticalLineTo(7f)
            horizontalLineToRelative(2f)
            verticalLineToRelative(6f)
            horizontalLineTo(6.8f)
            lineToRelative(3.6f, 3.6f)
            lineTo(9f, 18f)
            close()
          }
        }
        .build()
    return _enter!!
  }

private var _enter: ImageVector? = null
