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
public val arrows_outward: ImageVector
  get() {
    if (_arrows_outward != null) {
      return _arrows_outward!!
    }
    _arrows_outward =
      ImageVector.Builder(
          name = "arrows_outward",
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
            moveTo(17f, 17f)
            lineTo(15.6f, 15.6f)
            lineTo(18.18f, 13f)
            horizontalLineTo(13f)
            verticalLineTo(11f)
            horizontalLineToRelative(5.18f)
            lineTo(15.6f, 8.4f)
            lineTo(17f, 7f)
            lineToRelative(5f, 5f)
            lineToRelative(-5f, 5f)
            close()
            moveTo(7f, 17f)
            lineTo(2f, 12f)
            lineTo(7f, 7f)
            lineTo(8.4f, 8.4f)
            lineTo(5.83f, 11f)
            horizontalLineTo(11f)
            verticalLineToRelative(2f)
            horizontalLineTo(5.83f)
            lineTo(8.4f, 15.6f)
            lineTo(7f, 17f)
            close()
          }
        }
        .build()
    return _arrows_outward!!
  }

private var _arrows_outward: ImageVector? = null
